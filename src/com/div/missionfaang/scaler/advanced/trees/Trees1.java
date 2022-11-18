package com.div.missionfaang.scaler.advanced.trees;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

class Trees1
{
  static ArrayList<Integer> inorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.inorderTraversal( A, result );
  }

  static ArrayList<Integer> preorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.preorderTraversal( A, result );
  }

  static ArrayList<Integer> postorderTraversal( TreeNode A )
  {
    ArrayList<Integer> result = new ArrayList<>();
    return Trees1.postorderTraversal( A, result );
  }

  private static ArrayList<Integer> inorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result = Trees1.inorderTraversal( A.left, result );
    result.add( A.val );
    result = Trees1.inorderTraversal( A.right, result );
    return result;
  }

  private static ArrayList<Integer> preorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result.add( A.val );
    result = Trees1.preorderTraversal( A.left, result );
    result = Trees1.preorderTraversal( A.right, result );
    return result;
  }

  private static ArrayList<Integer> postorderTraversal( TreeNode A, ArrayList<Integer> result )
  {
    if( A == null )
    {
      return result;
    }
    result = Trees1.postorderTraversal( A.left, result );
    result = Trees1.postorderTraversal( A.right, result );
    result.add( A.val );
    return result;
  }

  private static ArrayList<ArrayList<Integer>> levelOrder( TreeNode A )
  {
    ArrayList<TreeNode> queue = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    TreeNode root = null;
    if( A != null )
    {
      ArrayList<Integer> rootLevel = new ArrayList<>();
      rootLevel.add( A.val );
      result.add( rootLevel );
      queue.add( A.left );
      queue.add( A.right );
      while( !queue.isEmpty() )
      {
        ArrayList<Integer> level = new ArrayList<>();
        ArrayList<TreeNode> tempQueue = new ArrayList<>();
        int size = queue.size();
        for( int i = 0; i < size; i++ )
        {
          if( queue.get( 0 ) != null )
          {
            level.add( queue.get( 0 ).val );
            tempQueue.add( queue.get( 0 ).left );
            tempQueue.add( queue.get( 0 ).right );
          }
          queue.remove( 0 );
        }
        queue = tempQueue;
        if( !level.isEmpty() )
        {
          result.add( level );
        }
      }
    }
    return result;
  }

  private static TreeNode buildTreeFromInorderAndPostorder( ArrayList<Integer> A, ArrayList<Integer> B )
  {
    return Trees1.buildTreeFromInorderAndPostorder( A, B, 0, A.size() - 1, 0, B.size() - 1 );
  }

  private static TreeNode buildTreeFromInorderAndPostorder( ArrayList<Integer> A, ArrayList<Integer> B, int ins, int ine, int pos, int poe )
  {
    if( ins > ine || poe < 0 )
    {
      return null;
    }
    TreeNode root = new TreeNode( B.get( poe ) );
    if( ins == ine )
    {
      return root;
    }
    int index = 0;
    for( int i = ins; i <= ine; i++ )
    {
      if( A.get( i ).equals( B.get( poe ) ) )
      {
        index = i;
        break;
      }
    }
    root.left = Trees1.buildTreeFromInorderAndPostorder( A, B, ins, index - 1, pos, pos - ins + index - 1 );
    root.right = Trees1.buildTreeFromInorderAndPostorder( A, B, index + 1, ine, poe - ine + index, poe - 1 );
    return root;
  }

  private static TreeNode buildTreeFromInorderAndPreorder( ArrayList<Integer> A, ArrayList<Integer> B )
  {
    return Trees1.buildTreeFromInorderAndPreorder( A, B, 0, A.size() - 1, 0, B.size() - 1 );
  }

  private static TreeNode buildTreeFromInorderAndPreorder( ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int ins, int ine, int prs, int pre )
  {
    if( prs > pre || ins > ine )
    {
      return null;
    }
    TreeNode root = new TreeNode( preOrder.get( prs ) );
    //    if( ins == ine )
    //    {
    //      return root;
    //    }
    int index = -1;
    for( int i = ins; i <= ine; i++ )
    {
      if( inOrder.get( i ).equals( preOrder.get( prs ) ) )
      {
        index = i;
        break;
      }
    }
    int length = index - ins;
    root.left = Trees1.buildTreeFromInorderAndPreorder( preOrder, inOrder, ins, index - 1, prs + 1, prs + length );
    root.right = Trees1.buildTreeFromInorderAndPreorder( preOrder, inOrder, index + 1, ine, prs + length + 1, pre );
    return root;
  }

  public static void main( String[] args )
  {
    //    TreeNode root = new TreeNode( 1 );
    //    root.left = new TreeNode( 2 );
    //    root.right = new TreeNode( 3 );
    //    root.left.left = new TreeNode( 4 );
    //    root.left.right = new TreeNode( 5 );
    //    root.right.left = new TreeNode( 6 );
    //    root.right.right = new TreeNode( 7 );
    //    root.left.left.left = new TreeNode( 8 );
    //    root.left.left.right = new TreeNode( 9 );
    //    root.left.right.left = new TreeNode( 10 );
    //    root.left.right.right = new TreeNode( 11 );
    //    root.right.left.left = new TreeNode( 12 );
    //    root.right.left.right = new TreeNode( 13 );
    //    root.right.right.left = new TreeNode( 14 );
    //    root.right.right.right = new TreeNode( 15 );
    //    System.out.println( Trees1.inorderTraversal( root ) );
    //    System.out.println( Trees1.preorderTraversal( root ) );
    //    System.out.println( Trees1.postorderTraversal( root ) );
    //    int[] arr1 = new int[] { 301, 7, 302, 103, 554, 202, 289, 359, 25, 171, 284, 191, 324, 184, 609, 40, 618, 622, 495, 417, 70, 400, 197, 31, 386, 199, 419,
    //        214, 684, 483, 107, 653, 71, 637, 617, 486, 545, 276, 405, 90, 605, 437, 61, 490, 390, 688, 223, 404, 250, 523, 508, 206, 534, 34, 682, 185, 641, 398,
    //        355, 290, 232, 208, 328, 52, 585, 373, 322, 476, 429, 694, 160, 443, 255, 182, 114, 92, 530, 385, 415, 584, 293, 218, 421, 62, 531, 441, 540, 353, 384,
    //        176, 234, 22, 665, 140, 378, 5, 611, 204, 263, 211, 431, 320, 252, 655, 418, 582, 332, 118, 138, 39, 702, 634, 647, 10, 181, 436, 664, 713, 342, 53,
    //        329, 101, 701, 364, 446, 265, 30, 217, 163, 229, 624, 716, 629, 81, 360, 76, 445, 652, 719, 520, 271, 28, 358, 587, 494, 581, 162, 560, 711, 600, 574,
    //        200, 349, 402, 699, 313, 517, 408, 222, 714, 345, 597, 336, 272, 685, 663, 603, 588, 602, 522, 456, 506, 675, 507, 47, 109, 703, 233, 579, 477, 121,
    //        282, 72, 369, 187, 122, 411, 535, 686, 186, 9, 496, 469, 166, 455, 696, 357, 154, 552, 78, 23, 170, 615, 366, 325, 529, 649, 247, 668, 316, 249, 201,
    //        704, 331, 608, 228, 559, 36, 511, 695, 123, 60, 412, 645, 209, 104, 46, 288, 564, 135, 189, 188, 625, 77, 536, 156, 15, 656, 479, 616, 63, 576, 268,
    //        654, 448, 80, 69, 74, 102, 150, 377, 351, 112, 18, 42, 129, 550, 161, 406, 275, 277, 108, 131, 726, 440, 515, 504, 718, 610, 489, 728, 432, 149, 546,
    //        219, 428, 626, 84, 594, 424, 257, 134, 532, 362, 175, 676, 59, 261, 533, 662, 677, 339, 116, 251, 613, 592, 41, 195, 598, 354, 57, 590, 596, 473, 497,
    //        500, 727, 32, 173, 237, 130, 410, 717, 642, 502, 352, 543, 463, 638, 599, 244, 254, 568, 389, 68, 426, 513, 21, 20, 157, 537, 693, 453, 451, 444, 333,
    //        169, 213, 167, 12, 323, 573, 58, 510, 372, 447, 706, 303, 620, 13, 572, 368, 452, 558, 117, 518, 413, 296, 91, 651, 724, 294, 146, 541, 88, 318, 143,
    //        422, 639, 337, 287, 650, 683, 220, 248, 94, 11, 397, 376, 565, 487, 470, 478, 488, 335, 44, 340, 343, 690, 633, 409, 295, 710, 612, 152, 420, 174, 577,
    //        442, 179, 643, 666, 393, 556, 692, 538, 309, 85, 387, 274, 414, 165, 562, 196, 326, 98, 231, 73, 672, 679, 338, 344, 240, 528, 589, 407, 467, 177, 27,
    //        627, 382, 503, 485, 64, 256, 370, 575, 210, 549, 97, 270, 51, 350, 258, 601, 279, 607, 317, 141, 392, 725, 54, 278, 99, 48, 674, 563, 363, 427, 236,
    //        159, 671, 673, 286, 105, 401, 604, 525, 307, 75, 527, 660, 241, 570, 321, 259, 381, 396, 636, 183, 394, 379, 262, 361, 667, 403, 712, 449, 136, 142, 1,
    //        516, 203, 566, 298, 458, 519, 621, 375, 148, 644, 89, 553, 678, 17, 198, 273, 471, 591, 305, 623, 383, 280, 283, 96, 66, 722, 628, 425, 125, 468, 100,
    //        512, 491, 79, 190, 472, 457, 698, 264, 230, 459, 260, 253, 224, 707, 580, 480, 465, 242, 729, 65, 715, 314, 484, 33, 330, 67, 548, 544, 557, 493, 705,
    //        539, 144, 395, 153, 238, 689, 172, 505, 168, 115, 243, 26, 281, 492, 434, 83, 567, 380, 670, 374, 3, 648, 82, 87, 194, 586, 438, 266, 56, 178, 299, 300,
    //        595, 659, 145, 708, 640, 212, 635, 435, 423, 128, 111, 681, 306, 561, 192, 38, 235, 120, 341, 721, 4, 216, 433, 225, 155, 207, 245, 227, 416, 632, 45,
    //        113, 720, 555, 391, 474, 367, 462, 348, 501, 308, 292, 606, 475, 285, 291, 310, 723, 226, 481, 460, 691, 499, 498, 454, 119, 8, 461, 137, 680, 631, 514,
    //        312, 687, 583, 164, 239, 221, 547, 267, 482, 319, 6, 37, 304, 16, 193, 180, 93, 430, 700, 132, 464, 646, 356, 86, 124, 526, 450, 14, 619, 509, 569, 346,
    //        43, 147, 205, 29, 466, 139, 2, 630, 151, 388, 334, 439, 95, 657, 50, 551, 246, 215, 297, 327, 269, 55, 669, 709, 126, 542, 614, 19, 24, 658, 35, 593,
    //        365, 371, 127, 578, 133, 106, 661, 158, 571, 697, 399, 347, 49, 524, 521, 110, 315, 311 };

    //    int[] arr2 = new int[] { 301, 302, 7, 554, 289, 25, 359, 171, 284, 191, 202, 184, 609, 618, 622, 40, 324, 417, 70, 197, 31, 400, 199, 214, 419, 684, 107,
    //        71, 637, 653, 483, 617, 386, 495, 276, 545, 405, 90, 61, 390, 223, 688, 404, 490, 437, 523, 508, 34, 534, 206, 250, 605, 185, 682, 355, 398, 290, 641,
    //        486, 328, 585, 52, 208, 322, 694, 429, 476, 160, 255, 443, 373, 114, 92, 385, 415, 530, 293, 218, 584, 62, 531, 441, 421, 353, 384, 234, 665, 140, 22,
    //        176, 540, 182, 5, 204, 263, 611, 211, 320, 431, 252, 582, 418, 39, 138, 634, 702, 118, 332, 181, 10, 647, 664, 713, 53, 342, 101, 329, 701, 265, 30,
    //        163, 217, 624, 229, 446, 716, 81, 629, 364, 436, 76, 445, 719, 520, 587, 358, 581, 494, 560, 711, 162, 574, 600, 699, 402, 349, 313, 200, 28, 271, 222,
    //        408, 714, 517, 652, 336, 272, 603, 522, 602, 588, 663, 685, 597, 456, 675, 507, 506, 109, 233, 579, 703, 47, 345, 282, 121, 72, 477, 187, 122, 411, 686,
    //        186, 535, 469, 496, 9, 369, 360, 655, 378, 232, 103, 455, 357, 696, 78, 23, 552, 615, 325, 366, 247, 316, 249, 704, 201, 668, 649, 529, 608, 331, 170,
    //        559, 511, 36, 123, 695, 412, 60, 209, 645, 228, 104, 288, 564, 46, 189, 188, 625, 135, 154, 156, 536, 576, 63, 268, 616, 479, 69, 80, 448, 654, 656, 15,
    //        102, 74, 77, 18, 112, 42, 550, 129, 351, 377, 275, 131, 108, 277, 406, 161, 440, 504, 515, 718, 546, 149, 432, 728, 489, 428, 626, 84, 219, 610, 424,
    //        134, 362, 532, 257, 676, 59, 175, 662, 677, 533, 613, 251, 116, 339, 592, 41, 261, 594, 598, 354, 590, 497, 473, 596, 173, 32, 727, 237, 500, 57, 717,
    //        410, 642, 130, 195, 352, 463, 543, 599, 638, 568, 254, 244, 502, 68, 21, 513, 157, 537, 693, 20, 453, 333, 444, 213, 167, 169, 323, 372, 510, 58, 706,
    //        447, 573, 12, 451, 620, 13, 303, 452, 117, 558, 518, 368, 296, 294, 146, 724, 651, 318, 88, 541, 91, 413, 572, 422, 287, 337, 639, 220, 683, 94, 248,
    //        650, 397, 565, 487, 376, 470, 44, 335, 343, 340, 488, 478, 409, 633, 295, 710, 690, 420, 152, 174, 612, 11, 179, 442, 393, 666, 692, 556, 309, 85, 538,
    //        643, 577, 143, 426, 274, 414, 562, 165, 98, 672, 338, 679, 73, 231, 326, 240, 589, 528, 177, 467, 27, 407, 344, 196, 503, 382, 64, 485, 256, 210, 575,
    //        51, 270, 97, 549, 370, 258, 601, 279, 141, 317, 607, 54, 99, 278, 674, 48, 725, 427, 363, 563, 392, 159, 671, 286, 105, 673, 604, 401, 307, 75, 660,
    //        527, 321, 259, 570, 241, 525, 183, 636, 361, 262, 379, 394, 667, 396, 381, 236, 350, 627, 387, 389, 726, 150, 166, 712, 449, 136, 1, 142, 566, 203, 298,
    //        621, 519, 148, 375, 458, 516, 17, 678, 553, 89, 273, 198, 591, 305, 471, 280, 383, 623, 96, 66, 628, 722, 125, 100, 491, 512, 468, 425, 283, 190, 472,
    //        698, 459, 253, 260, 230, 224, 264, 457, 480, 580, 465, 242, 65, 729, 484, 314, 33, 67, 330, 548, 557, 544, 705, 539, 493, 715, 395, 144, 707, 79, 238,
    //        689, 153, 505, 168, 243, 281, 26, 115, 83, 434, 492, 567, 670, 374, 380, 3, 87, 82, 300, 299, 178, 595, 56, 266, 708, 145, 212, 640, 659, 438, 586, 194,
    //        648, 172, 644, 435, 423, 635, 111, 681, 306, 192, 38, 235, 561, 341, 4, 216, 721, 155, 227, 245, 207, 416, 225, 45, 720, 113, 632, 433, 474, 391, 462,
    //        501, 292, 308, 606, 348, 367, 285, 310, 723, 226, 291, 460, 499, 454, 498, 119, 691, 8, 680, 137, 631, 461, 514, 481, 475, 555, 120, 687, 583, 239, 164,
    //        547, 482, 267, 221, 312, 37, 6, 193, 16, 304, 430, 93, 180, 132, 646, 464, 124, 526, 14, 450, 86, 356, 569, 509, 147, 43, 205, 346, 29, 139, 2, 466,
    //        151, 388, 439, 334, 630, 619, 700, 657, 551, 50, 215, 246, 95, 269, 327, 669, 709, 542, 126, 614, 24, 593, 35, 365, 658, 19, 578, 127, 158, 661, 106,
    //        133, 371, 399, 697, 347, 571, 55, 524, 521, 315, 110, 49, 297, 311, 319, 128, 403 };

    int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
    int[] arr2 = new int[] { 3, 2, 4, 1, 5 };
    ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
    ArrayList<Integer> array2 = ArrayUtility.convertArrayToList( arr2 );
    System.out.println( Trees1.postorderTraversal( Trees1.buildTreeFromInorderAndPreorder( array1, array2 ) ) );
  }

  public TreeNode deserializeBinaryTree( ArrayList<Integer> A )
  {
    TreeNode root = null;
    //    if( A.get( 0 ) != -1 )
    //    {
    //      front = new ListNode( A.get( 0 ) );
    //      tail
    //      for( int i = 0; i < A.size(); i++ )
    //      {
    //
    //      }
    //    }
    return root;
  }
}
